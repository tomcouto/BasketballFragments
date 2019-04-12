package edu.quinnipiac.ls09_fragments;

/**
 * Handler class deals with retrieving the information from the JSON and returning the string
 * in each specified value.
 */

import org.json.JSONException;
import org.json.JSONObject;

public class Handler {

    String pName;
    String pPosition;
    String pTeam;
    String pDivision;
    String pConf;

    //getName gets the players first and last name concats them and returns the string
    public String getName(String nameJsonStr) throws JSONException {
        JSONObject nameJSONObj = new JSONObject(nameJsonStr);
        String fullName = (nameJSONObj.getString("first_name")) + " " + (nameJSONObj.getString("last_name"));
        pName = fullName;
        return pName;
    }

    //gets the player's position from JSON
    public String getPosition(String positionJsonStr) throws JSONException {
            JSONObject positionJSONObj = new JSONObject(positionJsonStr);
            pPosition = positionJSONObj.getString("position");
            return pPosition;
    }

    //gets player's team from JSON
    public String getTeam(String teamJsonStr) throws JSONException {
        JSONObject teamJSONObj = new JSONObject(teamJsonStr);
        pTeam = teamJSONObj.getJSONObject("team").getString("full_name");
        return pTeam;
    }

    //gets player's division from JSON
    public String getDivision(String divisionJsonStr) throws JSONException {
        JSONObject divisionJSONObj = new JSONObject(divisionJsonStr);
        pDivision = divisionJSONObj.getJSONObject("team").getString("division");
        return pDivision;
    }

    //gets player's conference from JSON
    public String getConference(String conferenceJsonStr) throws JSONException {
        JSONObject conferenceJSONObj = new JSONObject(conferenceJsonStr);
        pConf = conferenceJSONObj.getJSONObject("team").getString("conference");
        return pConf;
    }

}
