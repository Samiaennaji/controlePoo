package Dao;
import Model.Incident;
import java.util.List;

public interface IncidentDao {
    void ajouterIncident(Incident incident);
    List<Incident> getTousLesIncidents();
    Incident chercherParId(String id);
    void supprimerIncident(String id);
}
