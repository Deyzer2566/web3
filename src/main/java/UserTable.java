import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@ManagedBean(name="userTable")
@ApplicationScoped
public class UserTable implements Serializable {
    private UserPoint point;
    private UUID uuid;
    private EntityManager entityManager;

    public UserTable(){
        this.uuid = UUID.randomUUID();
        this.point = new UserPoint();
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Web3Lab");

        this.entityManager = emfactory.createEntityManager();
    }

    public List<UserPoint> getPointsTable(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserPoint> query = cb.createQuery(UserPoint.class);
        Root<UserPoint> c = query.from(UserPoint.class);
        query.select(c);
        List<UserPoint> resultList = entityManager.createQuery(query).getResultList();
        return resultList;
    }

    public void setLastR(){
        if(getPointsTable().size() != 0)
            point.setR(getPointsTable().get(0).getR());
    }

    public void doCode(){
        point.setOwner(uuid.toString());
        point.check();
        entityManager.getTransaction().begin();
        entityManager.persist(point);
        entityManager.getTransaction().commit();
        point = new UserPoint();
        setLastR();
    }

    public void setPoint(UserPoint point) {
        this.point = point;
    }

    public UserPoint getPoint() {
        return point;
    }
}
