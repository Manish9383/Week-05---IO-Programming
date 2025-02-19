package com.bridgelabz.ipl_and_censor_analyzer;


import java.util.List;

public class CensorshipRules {
    public static void applyCensorship(List<IplMatch> matches) {
        for (IplMatch match : matches) {
            match.setTeam1(maskTeamName(match.getTeam1()));
            match.setTeam2(maskTeamName(match.getTeam2()));
            match.setWinner(maskTeamName(match.getWinner()));
            match.setPlayer_of_match("REDACTED");
        }
    }

    private static String maskTeamName(String teamName) {
        if (teamName.contains(" ")) {
            return teamName.substring(0, teamName.indexOf(" ")) + " ***";
        }
        return teamName;
    }
}
