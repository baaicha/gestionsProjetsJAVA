

package com.raven.form;

import java.sql.Date;


class Projet {
    private int projet_id;
    private String project_name;
    private Date dateDebut;
    private Date dateFin;
    private String MembresEquipe;
    private String etat;
    private int projet_manager_id;
     
    public Projet(int projet_id, String project_name,Date dateDebut, Date dateFin, String MembresEquipe, String etat, int projet_manager_id ){
        this.projet_id=projet_id;
        this.project_name=project_name;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.MembresEquipe=MembresEquipe;
        this.etat=etat;
        this.projet_manager_id=projet_manager_id;
    
    
    }

    public Projet(int projet_id, String project_name,Date dateDebut, Date dateFin,  String etat){
        this.projet_id=projet_id;
        this.project_name=project_name;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
//        this.MembresEquipe=MembresEquipe;
        this.etat=etat;
//        this.projet_manager_id=projet_manager_id;
    
    
    }
    public int getID(){
        return projet_id;
    }
    public String getName(){
        return project_name;
    }
    public Date getDB(){
        return dateDebut;
    }
    public Date getDF(){
        return dateFin;
    }
    public String getMembresEquipe(){
        return MembresEquipe;
    }
    public String getEtat(){
        return etat;
    }
    public int getProjet_manager_id(){
        return projet_manager_id;
    }
    

}
