package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Entity class for connector.
 *
 * @author Evgenii Morenkov
 */
@Entity
@Table(name = "CONNECTOR")
public class Connector {
    @Id
    private Integer connector_id;
    private String connector_name;
    private Integer connector_capacity;
    private Integer connector_node_id;

    @OneToMany(mappedBy = "connector")
    private List<Point> points;

    @ManyToOne
    @JoinColumn(name = "connector_node_id", referencedColumnName = "node_id")
    private Node node;


    /**
     * Sets new connector_node_id.
     *
     * @param connector_node_id New value of connector_node_id.
     */
    public void setConnector_node_id(Integer connector_node_id) {
        this.connector_node_id = connector_node_id;
    }

    /**
     * Sets new connector_id.
     *
     * @param connector_id New value of connector_id.
     */
    public void setConnector_id(Integer connector_id) {
        this.connector_id = connector_id;
    }

    /**
     * Gets points.
     *
     * @return Value of points.
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * Sets new points.
     *
     * @param points New value of points.
     */
    public void setPoints(List<Point> points) {
        this.points = points;
    }

    /**
     * Sets new connector_name.
     *
     * @param connector_name New value of connector_name.
     */
    public void setConnector_name(String connector_name) {
        this.connector_name = connector_name;
    }

    /**
     * Sets new node.
     *
     * @param node New value of node.
     */
    public void setNode(Node node) {
        this.node = node;
    }

    /**
     * Gets connector_node_id.
     *
     * @return Value of connector_node_id.
     */
    public Integer getConnector_node_id() {
        return connector_node_id;
    }

    /**
     * Gets node.
     *
     * @return Value of node.
     */
    public Node getNode() {
        return node;
    }

    /**
     * Gets connector_id.
     *
     * @return Value of connector_id.
     */
    public Integer getConnector_id() {
        return connector_id;
    }

    /**
     * Gets connector_capacity.
     *
     * @return Value of connector_capacity.
     */
    public Integer getConnector_capacity() {
        return connector_capacity;
    }

    /**
     * Gets connector_name.
     *
     * @return Value of connector_name.
     */
    public String getConnector_name() {
        return connector_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Connector)) {
            return false;
        }

        Connector connector = (Connector) o;

        if (connector_capacity != null ? !connector_capacity.equals(connector.connector_capacity)
                : connector.connector_capacity != null) {
            return false;
        }
        if (connector_id != null ? !connector_id.equals(connector.connector_id) : connector.connector_id != null) {
            return false;
        }
        if (connector_name != null ? !connector_name.equals(connector.connector_name)
                : connector.connector_name != null) {
            return false;
        }
        if (connector_node_id != null ? !connector_node_id.equals(connector.connector_node_id)
                : connector.connector_node_id != null) {
            return false;
        }
        if (points != null ? !points.equals(connector.points) : connector.points != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = connector_id != null ? connector_id.hashCode() : 0;
        result = 31 * result + (connector_name != null ? connector_name.hashCode() : 0);
        result = 31 * result + (connector_capacity != null ? connector_capacity.hashCode() : 0);
        result = 31 * result + (connector_node_id != null ? connector_node_id.hashCode() : 0);
        result = 31 * result + (points != null ? points.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Connector{" +
                "connector_id=" + connector_id +
                ", connector_name='" + connector_name + '\'' +
                ", connector_capacity=" + connector_capacity +
                ", connector_node_id=" + connector_node_id +
                ", points=" + points +
                ", node=" + node +
                '}';
    }
}
