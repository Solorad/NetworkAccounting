package jpa;

import javax.persistence.*;

/**
 * Entity class for point.
 *
 * @author Evgenii Morenkov
 */
@Entity
@Table(name="POINT")
public class Point {
    @EmbeddedId
    private PointId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_connector_id", referencedColumnName = "connector_id")
    private Connector connector;


    // Only one of {linkByLeftPoint, linkByRightPoint} can be initialized.
    @OneToOne(mappedBy="rightPoint", fetch = FetchType.LAZY)
    private Link linkByRightPoint;

    @OneToOne(mappedBy="leftPoint", fetch = FetchType.LAZY)
    private Link linkByLeftPoint;


    /**
     * Gets connector.
     *
     * @return Value of connector.
     */
    public Connector getConnector() {
        return connector;
    }

    /**
     * Sets new connector.
     *
     * @param connector New value of connector.
     */
    public void setConnector(Connector connector) {
        this.connector = connector;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(PointId id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public PointId getId() {
        return id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }

        Point point = (Point) o;

        if (id != null ? !id.equals(point.id) : point.id != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    /**
     * Gets leftPointInLink.
     *
     * @return Value of leftPointInLink.
     */
    public Link getLinkByLeftPoint() {
        return linkByLeftPoint;
    }

    /**
     * Gets rightPointInLink.
     *
     * @return Value of rightPointInLink.
     */
    public Link getLinkByRightPoint() {
        return linkByRightPoint;
    }

    /**
     * Sets new leftPointInLink.
     *
     * @param leftPointInLink New value of leftPointInLink.
     */
    public void setLinkByLeftPoint(Link leftPointInLink) {
        this.linkByLeftPoint = leftPointInLink;
    }

    /**
     * Sets new rightPointInLink.
     *
     * @param rightPointInLink New value of rightPointInLink.
     */
    public void setLinkByRightPoint(Link rightPointInLink) {
        this.linkByRightPoint = rightPointInLink;
    }
}
