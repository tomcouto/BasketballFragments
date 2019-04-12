package edu.quinnipiac.ls09_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTwo extends Fragment {
    String name;
    String team;
    String position;
    String division;
    String conference;


    public FragmentTwo() {
        // Required empty public constructor
    }

    public void setName(String name){this.name = name;}
    public void setTeam(String team){this.team = team;}
    public void setPosition(String position){this.position = position;}
    public void setDivision(String division){this.division = division;}
    public void setConference(String conference){this.conference = conference;}

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if(view != null) {

            Handler handler = new Handler();
            TextView playerName = view.findViewById(R.id.playerName);
            playerName.setText(playerName.getText() + handler.getpName());

            TextView playerTeam = view.findViewById(R.id.playerTeam);
            playerTeam.setText(playerTeam.getText() + handler.getpTeam());

            TextView playerPosition = view.findViewById(R.id.playerPos);
            playerPosition.setText(playerPosition.getText() + handler.getpPosition());

            TextView playerDivision = view.findViewById(R.id.playerDivision);
            playerDivision.setText(playerDivision.getText() + handler.getpDivision());

            TextView playerConference = view.findViewById(R.id.playerConf);
            playerConference.setText(playerConference.getText() + handler.getpConf());
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

}
