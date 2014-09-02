package jpa;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Embeddable id for point.
 *
 * @author Evgenii Morenkov
 */
@Embeddable
public class PointId implements Serializable {
    private Integer point_num;
    private Integer point_connector_id;


    /**
     * Gets point_num.
     *
     * @return Value of point_num.
     */
    public Integer getPoint_num() {
        return point_num;
    }

    /**
     * Sets new point_connector_id.
     *
     * @param point_connector_id New value of point_connector_id.
     */
    public void setPoint_connector_id(Integer point_connector_id) {
        this.point_connector_id = point_connector_id;
    }

    /**
     * Gets point_connector_id.
     *
     * @return Value of point_connector_id.
     */
    public Integer getPoint_connector_id() {
        return point_connector_id;
    }

    /**
     * Sets new point_num.
     *
     * @param point_num New value of point_num.
     */
    public void setPoint_num(Integer point_num) {
        this.point_num = point_num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PointId)) {
            return false;
        }

        PointId pointId = (PointId) o;

        if (point_connector_id != null ? !point_connector_id.equals(pointId.point_connector_id)
                : pointId.point_connector_id != null) {
            return false;
        }
        if (point_num != null ? !point_num.equals(pointId.point_num) : pointId.point_num != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = point_num != null ? point_num.hashCode() : 0;
        result = 31 * result + (point_connector_id != null ? point_connector_id.hashCode() : 0);
        return result;
    }
}
