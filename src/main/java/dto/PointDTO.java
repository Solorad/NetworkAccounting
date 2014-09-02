package dto;


/**
 * DTO class for point.
 *
 * @author Evgenii Morenkov
 */
public class PointDTO {
    private Integer pointNum;
    private Integer pointConnectorId;
    private ConnectorDTO connector;


    /**
     * Gets point_num.
     *
     * @return Value of point_num.
     */
    public Integer getPointNum() {
        return pointNum;
    }

    /**
     * Sets new point_connector_id.
     *
     * @param point_connector_id New value of point_connector_id.
     */
    public void setPointConnectorId(Integer point_connector_id) {
        this.pointConnectorId = point_connector_id;
    }

    /**
     * Gets point_connector_id.
     *
     * @return Value of point_connector_id.
     */
    public Integer getPointConnectorId() {
        return pointConnectorId;
    }

    /**
     * Sets new point_num.
     *
     * @param point_num New value of point_num.
     */
    public void setPointNum(Integer point_num) {
        this.pointNum = point_num;
    }

    /**
     * Gets connector.
     *
     * @return Value of connector.
     */
    public ConnectorDTO getConnector() {
        return connector;
    }

    /**
     * Sets new connector.
     *
     * @param connector New value of connector.
     */
    public void setConnector(ConnectorDTO connector) {
        this.connector = connector;
    }
}
