package ma.projet;

import jakarta.persistence.*;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiniProjetPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Connexion OK");

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
