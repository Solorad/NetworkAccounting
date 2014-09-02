package dto;

import java.util.List;

/**
 * DTO class for Node.
 *
 * @author Evgenii Morenkov
 */
public class ConnectorDTO {
    private Integer connectorId;
    private String connectorName;
    private Integer connectorCapacity;
    private Integer connectorNodeId;
    private List<PointDTO> pointDTOs;


    /**
     * Sets new connector_node_id.
     *
     * @param connector_node_id New value of connector_node_id.
     */
    public void setConnectorNodeId(Integer connector_node_id) {
        this.connectorNodeId = connector_node_id;
    }

    /**
     * Sets new connector_id.
     *
     * @param connector_id New value of connector_id.
     */
    public void setConnectorId(Integer connector_id) {
        this.connectorId = connector_id;
    }

    /**
     * Gets points.
     *
     * @return Value of points.
     */
    public List<PointDTO> getPointDTOs() {
        return pointDTOs;
    }

    /**
     * Sets new points.
     *
     * @param pointDTOs New value of points.
     */
    public void setPointDTOs(List<PointDTO> pointDTOs) {
        this.pointDTOs = pointDTOs;
    }

    /**
     * Sets new connector_name.
     *
     * @param connector_name New value of connector_name.
     */
    public void setConnectorName(String connector_name) {
        this.connectorName = connector_name;
    }

    /**
     * Gets connector_node_id.
     *
     * @return Value of connector_node_id.
     */
    public Integer getConnectorNodeId() {
        return connectorNodeId;
    }

    /**
     * Gets connector_id.
     *
     * @return Value of connector_id.
     */
    public Integer getConnectorId() {
        return connectorId;
    }

    /**
     * Gets connector_capacity.
     *
     * @return Value of connector_capacity.
     */
    public Integer getConnectorCapacity() {
        return connectorCapacity;
    }

    /**
     * Gets connector_name.
     *
     * @return Value of connector_name.
     */
    public String getConnectorName() {
        return connectorName;
    }

    /**
     * Sets new connector_capacity.
     *
     * @param connector_capacity New value of connector_capacity.
     */
    public void setConnectorCapacity(Integer connector_capacity) {
        this.connectorCapacity = connectorCapacity;
    }
}
