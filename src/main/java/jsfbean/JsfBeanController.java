package jsfbean;

import dto.LinkDTO;
import dto.NodeDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.DataService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * @author Evgenii Morenkov
 */
@ManagedBean
@SessionScoped
public class JsfBeanController implements Serializable {
    @ManagedProperty(value = "#{dataService}")
    private DataService dataService;
    @ManagedProperty(value = "#{jsfModel}")
    private JsfModel jsfModel;

    private final static Logger logger = LogManager.getLogger(JsfBeanController.class.getName());

    /**
     * Get all links for Node;
     *
     * @return list of links, connected with current node.
     */
    public List<LinkDTO> getAllLinksForNode() {
        return dataService.getAllLinksForNode(jsfModel.getNodeId());
    }

    public String showNodeLinks(Integer nodeId) {
        if (logger.isInfoEnabled()) {
            logger.info("showNodeLinks() in JsfBeanController.");
        }
        jsfModel.setNodeId(nodeId);
        return "node_definition";
    }

    /**
     * Get all nodes
     *
     * @return list of node
     */
    public List<NodeDTO> getAllNodes() {
        if (logger.isInfoEnabled()) {
            logger.info("getAllNodes() in JsfBeanController.");
        }
        List<NodeDTO> allNodes = dataService.getAllNodes();
        if (logger.isInfoEnabled()) {
            logger.info("we found {} nodes.", allNodes.size());
        }
        return allNodes;
    }

    /**
     * Sets new dataService.
     *
     * @param dataService New value of dataService.
     */
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }


    /**
     * Sets new jsfModel.
     *
     * @param jsfModel New value of jsfModel.
     */
    public void setJsfModel(JsfModel jsfModel) {
        this.jsfModel = jsfModel;
    }
}
