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


    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        name = (String) args.get("name");
        position = (String) args.get("position");
        team = (String) args.get("team");
        division = (String) args.get("division");
        conference = (String) args.get("conference");
        View view = getView();
        if(view != null) {

            TextView playerName = view.findViewById(R.id.playerName);
            playerName.setText(playerName.getText() + name);

            TextView playerTeam = view.findViewById(R.id.playerTeam);
            playerTeam.setText(playerTeam.getText() + team);

            TextView playerPosition = view.findViewById(R.id.playerPos);
            playerPosition.setText(playerPosition.getText() + position);

            TextView playerDivision = view.findViewById(R.id.playerDivision);
            playerDivision.setText(playerDivision.getText() + division);

            TextView playerConference = view.findViewById(R.id.playerConf);
            playerConference.setText(playerConference.getText() + conference);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

}
