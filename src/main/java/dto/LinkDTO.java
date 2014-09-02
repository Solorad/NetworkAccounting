package dto;

/**
 * DTO class for link.
 *
 * @author Evgenii Morenkov
 */
public class LinkDTO {
    private Integer leftPointConnectorId;
    private Integer leftPointNum;
    private Integer rightPointConnectorId;
    private Integer rightPointNum;
    private String leftConnectorName;
    private String leftNodeName;
    private String rightConnectorName;
    private String rightNodeName;

    /**
     * Default constructor.
     */
    public LinkDTO() {
    }

    /**
     * Constructor for link with sort.
     *
     * @param leftPointConnectorId- connector 1 id
     * @param leftPointNum - connector 1 point number
     * @param rightPointConnectorId - connector 2 id
     * @param rightPointNum - connector 2 point number
     */
    public LinkDTO(Integer leftPointConnectorId, Integer leftPointNum, Integer rightPointConnectorId,
                   Integer rightPointNum) {
        if (leftPointConnectorId < rightPointConnectorId
                || (leftPointConnectorId.equals(rightPointConnectorId) && leftPointNum < rightPointNum)) {
            this.leftPointConnectorId = leftPointConnectorId;
            this.leftPointNum = leftPointNum;
            this.rightPointConnectorId = rightPointConnectorId;
            this.rightPointNum = rightPointNum;
        } else {
            this.leftPointConnectorId = rightPointConnectorId;
            this.leftPointNum = rightPointNum;
            this.rightPointConnectorId = leftPointConnectorId;
            this.rightPointNum = leftPointNum;
        }
    }

    /**
     * Sets new left_point_num.
     *
     * @param left_point_num New value of left_point_num.
     */
    public void setLeftPointNum(Integer left_point_num) {
        this.leftPointNum = left_point_num;
    }

    /**
     * Gets left_point_num.
     *
     * @return Value of left_point_num.
     */
    public Integer getLeftPointNum() {
        return leftPointNum;
    }

    /**
     * Sets new right_point_connector_id.
     *
     * @param right_point_connector_id New value of right_point_connector_id.
     */
    public void setRightPointConnectorId(Integer right_point_connector_id) {
        this.rightPointConnectorId = right_point_connector_id;
    }

    /**
     * Gets right_point_connector_id.
     *
     * @return Value of right_point_connector_id.
     */
    public Integer getRightPointConnectorId() {
        return rightPointConnectorId;
    }

    /**
     * Sets new left_point_connector_id.
     *
     * @param left_point_connector_id New value of left_point_connector_id.
     */
    public void setLeftPointConnectorId(Integer left_point_connector_id) {
        this.leftPointConnectorId = left_point_connector_id;
    }

    /**
     * Sets new right_point_num.
     *
     * @param right_point_num New value of right_point_num.
     */
    public void setRightPointNum(Integer right_point_num) {
        this.rightPointNum = right_point_num;
    }

    /**
     * Gets left_point_connector_id.
     *
     * @return Value of left_point_connector_id.
     */
    public Integer getLeftPointConnectorId() {
        return leftPointConnectorId;
    }

    /**
     * Gets right_point_num.
     *
     * @return Value of right_point_num.
     */
    public Integer getRightPointNum() {
        return rightPointNum;
    }

    /**
     * Gets leftNodeName.
     *
     * @return Value of leftNodeName.
     */
    public String getLeftNodeName() {
        return leftNodeName;
    }

    /**
     * Gets rightNodeName.
     *
     * @return Value of rightNodeName.
     */
    public String getRightNodeName() {
        return rightNodeName;
    }

    /**
     * Gets rightConnectorName.
     *
     * @return Value of rightConnectorName.
     */
    public String getRightConnectorName() {
        return rightConnectorName;
    }

    /**
     * Sets new leftConnectorName.
     *
     * @param leftConnectorName New value of leftConnectorName.
     */
    public void setLeftConnectorName(String leftConnectorName) {
        this.leftConnectorName = leftConnectorName;
    }

    /**
     * Sets new leftNodeName.
     *
     * @param leftNodeName New value of leftNodeName.
     */
    public void setLeftNodeName(String leftNodeName) {
        this.leftNodeName = leftNodeName;
    }

    /**
     * Gets leftConnectorName.
     *
     * @return Value of leftConnectorName.
     */
    public String getLeftConnectorName() {
        return leftConnectorName;
    }

    /**
     * Sets new rightNodeName.
     *
     * @param rightNodeName New value of rightNodeName.
     */
    public void setRightNodeName(String rightNodeName) {
        this.rightNodeName = rightNodeName;
    }

    /**
     * Sets new rightConnectorName.
     *
     * @param rightConnectorName New value of rightConnectorName.
     */
    public void setRightConnectorName(String rightConnectorName) {
        this.rightConnectorName = rightConnectorName;
    }
}
