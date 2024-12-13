package Dao;

import Model.Incident;

import java.util.ArrayList;
import java.util.List;

public class IncidentDaoImpl implements IncidentDao{
    private List<Incident> incidents = new ArrayList<>();

    @Override
    public void ajouterIncident(Incident incident) {
        incidents.add(incident);
        System.out.println("Incident ajouté : " + incident);
    }

    @Override
    public List<Incident> getTousLesIncidents() {
        return incidents;
    }

    @Override
    public Incident chercherParId(String id) {
        return incidents.stream()
                .filter(incident -> incident.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void supprimerIncident(String id) {
        incidents.removeIf(incident -> incident.getId().equals(id));
        System.out.println("Incident supprimé avec ID : " + id);
    }
}
