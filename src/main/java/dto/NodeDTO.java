package dto;

import java.util.List;

/**
 * DTO class for node.
 *
 * @author Evgenii Morenkov
 */
public class NodeDTO {
    private Integer nodeId;
    private String nodeName;
    private String nodeRegion;
    private String nodeStreet;
    private String nodeAddress;
    private List<ConnectorDTO> connectors;
    private Integer pointNumber;
    private Integer freePointNumber;


    /**
     * Sets new node_region.
     *
     * @param node_region New value of node_region.
     */
    public void setNodeRegion(String node_region) {
        this.nodeRegion = node_region;
    }

    /**
     * Sets new node_name.
     *
     * @param node_name New value of node_name.
     */
    public void setNodeName(String node_name) {
        this.nodeName = node_name;
    }

    /**
     * Sets new node_address.
     *
     * @param node_address New value of node_address.
     */
    public void setNodeAddress(String node_address) {
        this.nodeAddress = node_address;
    }

    /**
     * Gets node_address.
     *
     * @return Value of node_address.
     */
    public String getNodeAddress() {
        return nodeAddress;
    }

    /**
     * Gets node_name.
     *
     * @return Value of node_name.
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * Sets new node_id.
     *
     * @param node_id New value of node_id.
     */
    public void setNodeId(Integer node_id) {
        this.nodeId = node_id;
    }

    /**
     * Sets new node_street.
     *
     * @param node_street New value of node_street.
     */
    public void setNodeStreet(String node_street) {
        this.nodeStreet = node_street;
    }

    /**
     * Gets node_id.
     *
     * @return Value of node_id.
     */
    public Integer getNodeId() {
        return nodeId;
    }

    /**
     * Gets node_street.
     *
     * @return Value of node_street.
     */
    public String getNodeStreet() {
        return nodeStreet;
    }

    /**
     * Gets node_region.
     *
     * @return Value of node_region.
     */
    public String getNodeRegion() {
        return nodeRegion;
    }

    /**
     * Sets new connectors.
     *
     * @param connectors New value of connectors.
     */
    public void setConnectors(List<ConnectorDTO> connectors) {
        this.connectors = connectors;
    }

    /**
     * Gets connectors.
     *
     * @return Value of connectors.
     */
    public List<ConnectorDTO> getConnectors() {
        return connectors;
    }

    /**
     * Gets pointNumber.
     *
     * @return Value of pointNumber.
     */
    public Integer getPointNumber() {
        return pointNumber;
    }

    /**
     * Sets new pointNumber.
     *
     * @param pointNumber New value of pointNumber.
     */
    public void setPointNumber(Integer pointNumber) {
        this.pointNumber = pointNumber;
    }

    /**
     * Sets new freePointNumber.
     *
     * @param freePointNumber New value of freePointNumber.
     */
    public void setFreePointNumber(Integer freePointNumber) {
        this.freePointNumber = freePointNumber;
    }

    /**
     * Gets freePointNumber.
     *
     * @return Value of freePointNumber.
     */
    public Integer getFreePointNumber() {
        return freePointNumber;
    }

    public Integer getConnectorNum() {
        return connectors == null ? 0 : connectors.size();
    }

    @Override
    public String toString() {
        return "NodeDTO{" +
                "nodeId=" + nodeId +
                ", nodeName='" + nodeName + '\'' +
                ", nodeRegion='" + nodeRegion + '\'' +
                ", nodeStreet='" + nodeStreet + '\'' +
                ", nodeAddress='" + nodeAddress + '\'' +
                ", connectors=" + connectors +
                ", pointNumber=" + pointNumber +
                ", freePointNumber=" + freePointNumber +
                '}';
    }
}
