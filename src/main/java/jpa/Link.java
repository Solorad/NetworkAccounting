package jpa;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity class for link.
 *
 * @author Evgenii Morenkov
 */
@Entity
@Table(name = "LINK")
public class Link {
    @EmbeddedId
    private LinkId id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
                         @JoinColumn(name = "left_point_connector_id", referencedColumnName = "point_connector_id"),
                         @JoinColumn(name = "left_point_num", referencedColumnName = "point_num")
                 })
    private Point leftPoint;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
                         @JoinColumn(name = "right_point_connector_id", referencedColumnName = "point_connector_id"),
                         @JoinColumn(name = "right_point_num", referencedColumnName = "point_num")
                 })
    private Point rightPoint;

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public LinkId getId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(LinkId id) {
        this.id = id;
    }


    /**
     * Sets new leftPoint.
     *
     * @param leftPoint New value of leftPoint.
     */
    public void setLeftPoint(Point leftPoint) {
        this.leftPoint = leftPoint;
    }

    /**
     * Gets rightPoint.
     *
     * @return Value of rightPoint.
     */
    public Point getRightPoint() {
        return rightPoint;
    }

    /**
     * Sets new rightPoint.
     *
     * @param rightPoint New value of rightPoint.
     */
    public void setRightPoint(Point rightPoint) {
        this.rightPoint = rightPoint;
    }

    /**
     * Gets leftPoint.
     *
     * @return Value of leftPoint.
     */
    public Point getLeftPoint() {
        return leftPoint;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", leftPoint=" + leftPoint +
                ", rightPoint=" + rightPoint +
                '}';
    }
}
