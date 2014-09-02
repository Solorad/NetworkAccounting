package service;

import dao.DataController;
import dto.ConnectorDTO;
import dto.LinkDTO;
import dto.NodeDTO;
import dto.PointDTO;
import jpa.Connector;
import jpa.Link;
import jpa.Node;
import jpa.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Data service class.
 *
 * @author Evgenii Morenkov
 */
@ManagedBean
@ApplicationScoped
public class DataService implements Serializable {
    @ManagedProperty(value = "#{dataController}")
    private DataController dataController;
    private final static Logger logger = LogManager.getLogger(DataService.class.getName());

    /**
     * Retrieve all jpa from DataController and transform them into DTO classes.
     *
     * @return NodeDTO list
     */
    public List<NodeDTO> getAllNodes() {
        List<Node> allNodes = dataController.getAllNodes();
        List<NodeDTO> nodeDTOs = new ArrayList<NodeDTO>();
        for (Node node : allNodes) {
            NodeDTO nodeDTO = new NodeDTO();
            nodeDTO.setNodeId(node.getNode_id());
            nodeDTO.setNodeName(node.getNode_name());
            nodeDTO.setNodeRegion(node.getNode_region());
            nodeDTO.setNodeStreet(node.getNode_street());
            nodeDTO.setNodeAddress(node.getNode_address());

            // work with connector.
            List<Connector> connectors = node.getConnectors();
            List<ConnectorDTO> connectorDTOs = new ArrayList<ConnectorDTO>();
            int pointNumber = 0;
            int freePointNumber = 0;
            if (connectors != null) {
                for (Connector connector : connectors) {
                    ConnectorDTO connectorDTO = new ConnectorDTO();
                    connectorDTO.setConnectorId(connector.getConnector_id());
                    connectorDTO.setConnectorName(connector.getConnector_name());
                    connectorDTO.setConnectorCapacity(connector.getConnector_capacity());
                    if (connector.getConnector_capacity() != null) {
                        pointNumber += connector.getConnector_capacity();
                        freePointNumber += connector.getConnector_capacity();
                    }
                    connectorDTO.setConnectorNodeId(node.getNode_id());
                    // work with point.
                    List<Point> points = connector.getPoints();
                    List<PointDTO> pointDTOs = new ArrayList<PointDTO>();
                    for (Point point : points) {
                        PointDTO dto = new PointDTO();
                        dto.setPointConnectorId(point.getId().getPoint_connector_id());
                        dto.setPointNum(point.getId().getPoint_num());
                        pointDTOs.add(dto);
                    }
                    connectorDTO.setPointDTOs(pointDTOs);
                    freePointNumber -= points.size();
                    connectorDTOs.add(connectorDTO);
                }
            }
            nodeDTO.setConnectors(connectorDTOs);
            nodeDTO.setPointNumber(pointNumber);
            nodeDTO.setFreePointNumber(freePointNumber);
            nodeDTOs.add(nodeDTO);
        }
        if (logger.isInfoEnabled()) {
            logger.info("DataService getAllNodes() finished found {} dto", nodeDTOs.size());
            logger.info("DataService getAllNodes(): ", nodeDTOs);
        }
        return nodeDTOs;
    }

    public List<LinkDTO> getAllLinksForNode(Integer nodeNum) {
        List<Link> links = dataController.getAllLinks(nodeNum);
        List<LinkDTO> dtoLinks = new ArrayList<LinkDTO>();
        for (Link link : links) {
            LinkDTO linkDTO = new LinkDTO(
                    link.getId().getLeft_point_connector_id(),
                    link.getId().getLeft_point_num(),
                    link.getId().getRight_point_connector_id(),
                    link.getId().getRight_point_num()
            );
            linkDTO.setLeftNodeName(link.getLeftPoint().getConnector().getNode().getNode_name());
            linkDTO.setLeftConnectorName(link.getLeftPoint().getConnector().getConnector_name());
            linkDTO.setRightNodeName(link.getRightPoint().getConnector().getNode().getNode_name());
            linkDTO.setRightConnectorName(link.getRightPoint().getConnector().getConnector_name());
            dtoLinks.add(linkDTO);
        }
        return dtoLinks;
    }

    /**
     * Sets new dataController.
     *
     * @param dataController New value of dataController.
     */
    public void setDataController(DataController dataController) {
        this.dataController = dataController;
    }
}
