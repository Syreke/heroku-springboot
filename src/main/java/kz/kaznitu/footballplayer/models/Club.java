package kz.kaznitu.footballplayer.models;

import javax.persistence.*;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clubId;

    private String fullName;

    private String league;

    public Club() {
    }

    public Club(String fullName, String league) {
        this.fullName = fullName;
        this.league = league;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }
}
