package org.uni.personal;

public class Mitarbeiter {
    private int mitarbeiterNr;
    private String name;
    protected double gehalt;
    private String jobbezeichnung;

    public Mitarbeiter(int mitarbeiterNr, String name, double gehalt, String jobbezeichnung) {
        this.mitarbeiterNr = mitarbeiterNr;
        this.name = name;
        this.gehalt = gehalt;
        this.jobbezeichnung = jobbezeichnung;
    }

    public void anzeigen() {
        IO.println("Mitarbeiter Nr: " + mitarbeiterNr);
        IO.println("Name: " + name);
        IO.println("Job: " + jobbezeichnung);
        IO.println("Gehalt: " + gehalt + " EUR");
        IO.println(getJobInfo());
        IO.println("-------------------------");
    }

    public void erhoeheGehalt(double prozent) {
        if (prozent < 0) {
            IO.println("Fehler: Negative Erhöhung ignoriert.");
            return;
        }
        if (prozent > 20) {
            IO.println("Warnung: Gehaltserhöhung über 20%!");
        }
            this.gehalt = this.gehalt + this.gehalt * (prozent / 100.0);
    }

    public String getJobInfo() {
        return "Job: " + this.jobbezeichnung;
    }

    public int getMitarbeiterNr() { return mitarbeiterNr; }
    public String getName() { return name; }
    public double getGehalt() { return gehalt; }
    public String getJobbezeichnung() { return jobbezeichnung; }
}