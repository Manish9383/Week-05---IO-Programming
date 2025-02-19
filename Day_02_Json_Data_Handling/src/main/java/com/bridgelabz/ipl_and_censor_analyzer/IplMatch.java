package com.bridgelabz.ipl_and_censor_analyzer;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.bean.CsvBindByName;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class IplMatch {
    @CsvBindByName(column = "match_id")
    private int match_id;

    @CsvBindByName(column = "team1")
    private String team1;

    @CsvBindByName(column = "team2")
    private String team2;

    @CsvBindByName(column = "score_team1")
    private int score_team1;

    @CsvBindByName(column = "score_team2")
    private int score_team2;

    @CsvBindByName(column = "winner")
    private String winner;

    @CsvBindByName(column = "player_of_match")
    private String player_of_match;

    public IplMatch(int match_id, String team1, String team2, int score_team1, int score_team2, String winner, String player_of_match) {
        this.match_id = match_id;
        this.team1 = team1;
        this.team2 = team2;
        this.score_team1 = score_team1;
        this.score_team2 = score_team2;
        this.winner = winner;
        this.player_of_match = player_of_match;
    }

    public IplMatch() {}

    public int getMatch_id() { return match_id; }
    public void setMatch_id(int match_id) { this.match_id = match_id; }

    public String getTeam1() { return team1; }
    public void setTeam1(String team1) { this.team1 = team1; }

    public String getTeam2() { return team2; }
    public void setTeam2(String team2) { this.team2 = team2; }

    public int getScore_team1() { return score_team1; }
    public void setScore_team1(int score_team1) { this.score_team1 = score_team1; }

    public int getScore_team2() { return score_team2; }
    public void setScore_team2(int score_team2) { this.score_team2 = score_team2; }

    public String getWinner() { return winner; }
    public void setWinner(String winner) { this.winner = winner; }

    public String getPlayer_of_match() { return player_of_match; }
    public void setPlayer_of_match(String player_of_match) { this.player_of_match = player_of_match; }
}
