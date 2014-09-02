package dao;

import jpa.Connector;
import jpa.Link;
import jpa.Node;
import jpa.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Data controller class.
 *
 * @author Evgenii Morenkov
 */
@ManagedBean
@ApplicationScoped
public class DataController {

    private EntityManager em;
    private final static Logger logger = LogManager.getLogger(DataController.class.getName());

    @PostConstruct
    public void init() {
        Properties properties = new Properties();
        properties.setProperty("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        properties.setProperty("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/NETWORK");
        properties.setProperty("javax.persistence.jdbc.user", "root");
        properties.setProperty("javax.persistence.jdbc.password", "1111");
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("network", properties);
        em = emf.createEntityManager();
    }

    /**
     * Retrieves all available nodes.
     *
     * @return node list
     */
    public List<Node> getAllNodes() {
        if (logger.isInfoEnabled()) {
            logger.info("Get all nodes starts.");
        }
        CriteriaBuilder queryBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Node> q = queryBuilder.createQuery(Node.class);
        Root<Node> node = q.from(Node.class);
        q.select(node);
        TypedQuery<Node> query = em.createQuery(q);

        List<Node> resultList = query.getResultList();
        if (logger.isInfoEnabled()) {
            logger.info("Get all nodes finished. Found {} nodes.", resultList.size());
        }
        return resultList;
    }

    /**
     * Retrieves all available links.
     *
     * @return link list
     */
    public List<Link> getAllLinks(Integer nodeId) {
        if (logger.isInfoEnabled()) {
            logger.info("getAllLinks for node with id='{}' starts.", nodeId);
        }
        List<Link> links = new ArrayList<Link>();
        Node node = em.find(Node.class, nodeId);

        // black set for links, that we have already found.
        Set<Point> foundLinksWithPoints = new HashSet<Point>();
        if (node.getConnectors() == null) {
            return links;
        }

        for (Connector connector : node.getConnectors()) {
            System.out.println("  connector = " + connector);
            if (connector.getPoints() == null) {
                continue;
            }
            for (Point point : connector.getPoints()) {
                System.out.println("    point = " + point);
                // check, that current point hasn't already appeared in links
                if (point.getLinkByLeftPoint() != null && !foundLinksWithPoints.contains(point)) {
                    // add 2nd point from link in "black set" for links, that we have already found.
                    foundLinksWithPoints.add(point.getLinkByLeftPoint().getRightPoint());
                    links.add(point.getLinkByLeftPoint());
                } else if (point.getLinkByRightPoint() != null && !foundLinksWithPoints.contains(point)) {
                    // add 2nd point from link in "black set" for links, that we have already found.
                    foundLinksWithPoints.add(point.getLinkByRightPoint().getLeftPoint());
                    links.add(point.getLinkByRightPoint());
                }
            }
        }
        return links;
    }

    /**
     * Sets new em.
     *
     * @param em New value of em.
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
}
