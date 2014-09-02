package jpa;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Embeddable id for link.
 *
 * @author Evgenii Morenkov
 */
@Embeddable
public class LinkId implements Serializable {
    private Integer left_point_num;
    private Integer left_point_connector_id;
    private Integer right_point_num;
    private Integer right_point_connector_id;


    /**
     * Sets new left_point_num.
     *
     * @param left_point_num New value of left_point_num.
     */
    public void setLeft_point_num(Integer left_point_num) {
        this.left_point_num = left_point_num;
    }

    /**
     * Gets left_point_num.
     *
     * @return Value of left_point_num.
     */
    public Integer getLeft_point_num() {
        return left_point_num;
    }

    /**
     * Sets new right_point_connector_id.
     *
     * @param right_point_connector_id New value of right_point_connector_id.
     */
    public void setRight_point_connector_id(Integer right_point_connector_id) {
        this.right_point_connector_id = right_point_connector_id;
    }

    /**
     * Gets right_point_connector_id.
     *
     * @return Value of right_point_connector_id.
     */
    public Integer getRight_point_connector_id() {
        return right_point_connector_id;
    }

    /**
     * Sets new left_point_connector_id.
     *
     * @param left_point_connector_id New value of left_point_connector_id.
     */
    public void setLeft_point_connector_id(Integer left_point_connector_id) {
        this.left_point_connector_id = left_point_connector_id;
    }

    /**
     * Sets new right_point_num.
     *
     * @param right_point_num New value of right_point_num.
     */
    public void setRight_point_num(Integer right_point_num) {
        this.right_point_num = right_point_num;
    }

    /**
     * Gets left_point_connector_id.
     *
     * @return Value of left_point_connector_id.
     */
    public Integer getLeft_point_connector_id() {
        return left_point_connector_id;
    }

    /**
     * Gets right_point_num.
     *
     * @return Value of right_point_num.
     */
    public Integer getRight_point_num() {
        return right_point_num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinkId)) {
            return false;
        }

        LinkId linkId = (LinkId) o;

        if (left_point_connector_id != null ? !left_point_connector_id.equals(linkId.left_point_connector_id)
                : linkId.left_point_connector_id != null) {
            return false;
        }
        if (left_point_num != null ? !left_point_num.equals(linkId.left_point_num) : linkId.left_point_num != null) {
            return false;
        }
        if (right_point_connector_id != null ? !right_point_connector_id.equals(linkId.right_point_connector_id)
                : linkId.right_point_connector_id != null) {
            return false;
        }
        if (right_point_num != null ? !right_point_num.equals(linkId.right_point_num)
                : linkId.right_point_num != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = left_point_num != null ? left_point_num.hashCode() : 0;
        result = 31 * result + (left_point_connector_id != null ? left_point_connector_id.hashCode() : 0);
        result = 31 * result + (right_point_num != null ? right_point_num.hashCode() : 0);
        result = 31 * result + (right_point_connector_id != null ? right_point_connector_id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LinkId{" +
                "left_point_num=" + left_point_num +
                ", left_point_connector_id=" + left_point_connector_id +
                ", right_point_num=" + right_point_num +
                ", right_point_connector_id=" + right_point_connector_id +
                '}';
    }
}
