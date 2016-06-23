package javaGeneratedHtmlCode;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by r730819 on 6/23/2016.
 */
public class stateSelectList {
    protected Map getStateList(HttpServletRequest request)throws Exception{
        Map stateList = new HashMap();
        Map<String, String> state = new LinkedHashMap<String, String>();

        state.put("NA", "");
        state.put("AK", "Alaska");
        state.put("AL", "Alabama");
        state.put("AR", "Arkansas");
        state.put("AZ", "Arizona");
        state.put("CA", "California");
        state.put("CO", "Colorado");
        state.put("CT", "Connecticut");
        state.put("DC", "District of Columbia");
        state.put("DE", "Delaware");
        state.put("FL", "Florida");
        state.put("GA", "Georgia");
        state.put("HI", "Hawaii");
        state.put("IA", "Iowa");
        state.put("ID", "Idaho");
        state.put("IL", "Illinois");
        state.put("IN", "Indiana");
        state.put("KS", "Kansas");
        state.put("KY", "Kentucky");
        state.put("LA", "Louisiana");
        state.put("MA", "Massachusetts");
        state.put("MD", "Maryland");
        state.put("ME", "Maine");
        state.put("MI", "Michigan");
        state.put("MN", "Minnesota");
        state.put("MO", "Missouri");
        state.put("MS", "Mississippi");
        state.put("MT", "Montana");
        state.put("NC", "North Carolina");
        state.put("ND", "North Dakota");
        state.put("NE", "Nebraska");
        state.put("NH", "New Hampshire");
        state.put("NJ", "New Jersey");
        state.put("NM", "New Mexico");
        state.put("NV", "Nevada");
        state.put("NY", "New York");
        state.put("OH", "Ohio");
        state.put("OK", "Oklahoma");
        state.put("OR", "Oregon");
        state.put("PA", "Pennsylvania");
        state.put("PR", "Puerto Rico");
        state.put("RI", "Rhode Island");
        state.put("SC", "South Carolina");
        state.put("SD", "South Dakot");
        state.put("TN", "Tennessee");
        state.put("TX", "Texas");
        state.put("UT", "Utah");
        state.put("VA", "Virginia");
        state.put("VT", "Vermont");
        state.put("WA", "Washington");
        state.put("WI", "Wisconsin");
        state.put("WV", "West Virginia");
        state.put("WY", "Wyoming");

       stateList.put("stateList", state);

        return stateList;
    }
}
