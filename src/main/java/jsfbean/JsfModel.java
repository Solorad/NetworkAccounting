package jsfbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Model class for jsf pages.
 *
 * @author Evgenii.Morenkov
 */
@ManagedBean
@SessionScoped
public class JsfModel implements Serializable {
    private Integer rowsPerPage;
    private Integer nodeId;

    @PostConstruct
    public void init() {
        rowsPerPage = 10;
    }

    /**
     * Gets rowsPerPage.
     *
     * @return Value of rowsPerPage.
     */
    public Integer getRowsPerPage() {
        return rowsPerPage;
    }

    /**
     * Gets nodeId.
     *
     * @return Value of nodeId.
     */
    public Integer getNodeId() {
        return nodeId;
    }

    /**
     * Sets new rowsPerPage.
     *
     * @param rowsPerPage New value of rowsPerPage.
     */
    public void setRowsPerPage(Integer rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    /**
     * Sets new nodeId.
     *
     * @param nodeId New value of nodeId.
     */
    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }
}
