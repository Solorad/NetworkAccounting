package jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Entity class for node.
 *
 * @author Evgenii Morenkov
 */
@Entity
@Table(name = "NODE")
public class Node {
    @Id
    private Integer node_id;
    private String node_name;
    private String node_region;
    private String node_street;
    private String node_address;
    @OneToMany(mappedBy = "node")
    private List<Connector> connectors;


    /**
     * Sets new node_region.
     *
     * @param node_region New value of node_region.
     */
    public void setNode_region(String node_region) {
        this.node_region = node_region;
    }

    /**
     * Sets new node_name.
     *
     * @param node_name New value of node_name.
     */
    public void setNode_name(String node_name) {
        this.node_name = node_name;
    }

    /**
     * Sets new node_address.
     *
     * @param node_address New value of node_address.
     */
    public void setNode_address(String node_address) {
        this.node_address = node_address;
    }

    /**
     * Gets node_address.
     *
     * @return Value of node_address.
     */
    public String getNode_address() {
        return node_address;
    }

    /**
     * Gets node_name.
     *
     * @return Value of node_name.
     */
    public String getNode_name() {
        return node_name;
    }

    /**
     * Sets new node_id.
     *
     * @param node_id New value of node_id.
     */
    public void setNode_id(Integer node_id) {
        this.node_id = node_id;
    }

    /**
     * Sets new node_street.
     *
     * @param node_street New value of node_street.
     */
    public void setNode_street(String node_street) {
        this.node_street = node_street;
    }

    /**
     * Gets node_id.
     *
     * @return Value of node_id.
     */
    public Integer getNode_id() {
        return node_id;
    }

    /**
     * Gets node_street.
     *
     * @return Value of node_street.
     */
    public String getNode_street() {
        return node_street;
    }

    /**
     * Gets node_region.
     *
     * @return Value of node_region.
     */
    public String getNode_region() {
        return node_region;
    }

    /**
     * Sets new connectors.
     *
     * @param connectors New value of connectors.
     */
    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }

    /**
     * Gets connectors.
     *
     * @return Value of connectors.
     */
    public List<Connector> getConnectors() {
        return connectors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }

        Node node = (Node) o;

        if (connectors != null ? !connectors.equals(node.connectors) : node.connectors != null) {
            return false;
        }
        if (node_address != null ? !node_address.equals(node.node_address) : node.node_address != null) {
            return false;
        }
        if (node_id != null ? !node_id.equals(node.node_id) : node.node_id != null) {
            return false;
        }
        if (node_name != null ? !node_name.equals(node.node_name) : node.node_name != null) {
            return false;
        }
        if (node_region != null ? !node_region.equals(node.node_region) : node.node_region != null) {
            return false;
        }
        if (node_street != null ? !node_street.equals(node.node_street) : node.node_street != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = node_id != null ? node_id.hashCode() : 0;
        result = 31 * result + (node_name != null ? node_name.hashCode() : 0);
        result = 31 * result + (node_region != null ? node_region.hashCode() : 0);
        result = 31 * result + (node_street != null ? node_street.hashCode() : 0);
        result = 31 * result + (node_address != null ? node_address.hashCode() : 0);
        result = 31 * result + (connectors != null ? connectors.hashCode() : 0);
        return result;
    }
}
