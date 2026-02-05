
    class NurPraesenz {
    <<interface>>
    +getPraesenzgrund() String
    }

    class Medium {
        <<abstract>>
        -id : String
        -titel : String
        -erscheinungsjahr : int
        -istAusgeliehen : boolean
        +Medium(id: String, titel: String, jahr: int)
        +getId() String
        +getTitel() String
        +getErscheinungsjahr() int
        +istVerfuegbar() boolean
        +setVerfuegbar(status: boolean) void
        +berechneLeihgebuehr() double*
    }


    class Book {
        -autor : String
        -seitenanzahl : int
        +Book(id: String, titel: String, jahr: int, autor: String, seiten: int)
        +getAutor() String
        +getSeitenanzahl() int
        +berechneLeihgebuehr() double
    }

    class DVD {
        -laufzeit : int
        -fsk : int
        +DVD(id: String, titel: String, jahr: int, laufzeit: int, fsk: int)
        +getLaufzeit() int
        +getFsk() int
        +berechneLeihgebuehr() double
    }

    class Magazine {
        +Magazine(id: String, titel: String, jahr: int)
        +berechneLeihgebuehr() double
    }

    class ReferenceBook {
        -fachgebiet : String
        +ReferenceBook(id: String, titel: String, jahr: int, autor: String, seiten: int, fach: String)
        +getFachgebiet() String
        +getPraesenzgrund() String
    }

    class Loan {
        -medium : Medium
        -benutzerName : String
        -ausleihDatum : Date
        -rueckgabeDatum : Date
        -tatsaechlichesRueckgabeDatum : Date
        +Loan(medium: Medium, benutzer: String, datum: Date, rueckgabe: Date)
        +berechneGesamtgebuehr(tage: int) double
    }

    class Library {
        -medienListe : ArrayList~Medium~
        -ausleihListe : ArrayList~Loan~
        +addMedium(m: Medium) void
        +removeMedium(id: String) void
        +findMediumById(id: String) Medium
        +ausleihen(mediumId: String, benutzer: String, datum: String, rueckgabe: String) Loan
        +zurueckgeben(mediumId: String) void
        +zeigeUeberfaelligeAusleihen() void
    }

    Medium <|-- Book
    Medium <|-- DVD
    Medium <|-- Magazine
    Book <|-- ReferenceBook
    NurPraesenz <|.. ReferenceBook : implements
    
    Library "1" o-- "*" Medium : verwaltet
    Library "1" o-- "*" Loan : verwaltet
    Loan "0..*" --> "1" Medium : bezieht sich auf