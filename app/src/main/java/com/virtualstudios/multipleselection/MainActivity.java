package com.virtualstudios.multipleselection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TvShowsListener {

    private Button buttonAddToWatchlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView tvShowsRecyclerView = findViewById(R.id.tvShowsRecyclerView);
        buttonAddToWatchlist = findViewById(R.id.buttonAddToWatchlist);

        final List<TvShow> tvShows = new ArrayList<>();

        TvShow the100 = new TvShow();
        the100.image = R.drawable.the_100;
        the100.name = "The 100";
        the100.rating = 5f;
        the100.createdBy = "Jason Rothenberg";
        the100.story = "The series is set 97 years after a devastating nuclear war wiped out almost all life on Earth.";
        tvShows.add(the100);

        TvShow lostInSpace = new TvShow();
        lostInSpace.image = R.drawable.lost_in_space;
        lostInSpace.name = "Lost in Space";
        lostInSpace.rating = 4.5f;
        lostInSpace.createdBy = "Irwin Allen, Matt Sazama, Burk Sharpless";
        lostInSpace.story = "Set 30 years in the future, colonization in space is now a reality, and the Robinson family is among those.";
        tvShows.add(lostInSpace);

        TvShow vikings = new TvShow();
        vikings.image = R.drawable.vikings;
        vikings.name = "Vikings";
        vikings.rating = 4.5f;
        vikings.createdBy = "Michael Hirst";
        vikings.story = "The adventures of a Ragnar Lothbrok: the greatest hero of his age. The series tells the saga of Ragnar's band of Viking brothers and his family as he rises to become King of the Viking tribes. ";
        tvShows.add(vikings);

        TvShow travellers = new TvShow();
        travellers.image = R.drawable.travellers;
        travellers.name = "Travelers";
        travellers.rating = 4f;
        travellers.createdBy = "Brad Wright";
        travellers.story = "Hundreds of years from now, the last surviving humans discover the means of sending consciousness back through time, directly into people in the 21st century.";
        tvShows.add(travellers);

        TvShow futureman = new TvShow();
        futureman.image = R.drawable.future_man;
        futureman.name = "Future Man ";
        futureman.rating = 4f;
        futureman.createdBy = "Kyle Hunter, Howard Overman, Ariel Shaffir";
        futureman.story = "Josh Futturman, a janitor by day and a gamer by night, is recruited by mysterious visitors to travel through time to prevent the extinction of humanity.";
        tvShows.add(futureman);

        TvShow breakingBad = new TvShow();
        breakingBad.image = R.drawable.breaking_bad;
        breakingBad.name = "Breaking Bad";
        breakingBad.rating = 4f;
        breakingBad.createdBy = "Vince Gilligan";
        breakingBad.story = "When chemistry teacher Walter White is diagnosed with Stage III cancer and given only two years to live, he decides he has nothing to lose. ";
        tvShows.add(breakingBad);

        TvShow theExpanse = new TvShow();
        theExpanse.image = R.drawable.the_expanse;
        theExpanse.name = "The Expanse";
        theExpanse.rating = 4f;
        theExpanse.createdBy = "Mark Fergus, Hawk Ostby";
        theExpanse.story = "Two hundred years in the future, in a fully colonized solar system, police detective Josephus Miller (Thomas Jane), who was born in the asteroid belt, is given the assignment to find a missing young woman.";
        tvShows.add(theExpanse);

        TvShow theWalkingDead = new TvShow();
        theWalkingDead.image = R.drawable.the_walking_dead;
        theWalkingDead.name = "The Walking Dead ";
        theWalkingDead.rating = 4.5f;
        theWalkingDead.createdBy = "Frank Darabont, Angela Kang";
        theWalkingDead.story = "Sheriff Deputy Rick Grimes gets shot and falls into a coma. When awoken he finds himself in a Zombie Apocalypse.";
        tvShows.add(theWalkingDead);

        TvShow theRain = new TvShow();
        theRain.image = R.drawable.the_rain;
        theRain.name = "The Rain";
        theRain.rating = 4f;
        theRain.createdBy = "Jannik Tai Mosholt, Christian Potalivo, Esben Toft Jacobsen";
        theRain.story = "The world as we know it has ended. Six years after a brutal virus carried by the rain wiped out almost all humans in Scandinavia, two Danish siblings emerge from the safety of their bunker to find all remnants of civilization gone.";
        tvShows.add(theRain);

        TvShow lost = new TvShow();
        lost.image = R.drawable.lost;
        lost.name = "Lost";
        lost.rating = 4.5f;
        lost.createdBy = "J.J. Abrams, Jeffrey Lieber, Damon Lindelof";
        lost.story = "The past, present, and future lives of surviving Oceanic Flight 815 passengers are dramatically intertwined as a fight for survival ensues in a quest for answers after crashlanding on a mysterious island. ";
        tvShows.add(lost);

        final TvShowsAdapter tvShowsAdapter = new TvShowsAdapter(tvShows, this);
        tvShowsRecyclerView.setAdapter(tvShowsAdapter);

        buttonAddToWatchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<TvShow> selectedTvShows = tvShowsAdapter.getSelectedTvShows();

                StringBuilder tvShowsNames = new StringBuilder();
                for (int i = 0; i < selectedTvShows.size(); i++) {

                    if (i == 0) {
                        tvShowsNames.append(selectedTvShows.get(i).name);
                    } else {
                        tvShowsNames.append("\n").append(selectedTvShows.get(i).name);
                    }

                }
                Toast.makeText(MainActivity.this, tvShowsNames.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onTvShowAction(Boolean isSelected) {
        if (isSelected) {
            buttonAddToWatchlist.setVisibility(View.VISIBLE);
        } else {
            buttonAddToWatchlist.setVisibility(View.GONE);
        }
    }
}