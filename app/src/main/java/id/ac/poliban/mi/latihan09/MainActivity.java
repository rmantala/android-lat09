package id.ac.poliban.mi.latihan09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] ss = {
            "Chelsea FC",
            "Liverpol FC",
            "Leicester FC",
            "Watford FC",
            "Newcastle FC",
            "Totenham Hotspur FC",
            "Arsenal FC",
            "Manchester City FC",
            "Manchester United FC",
            "Nothingham Forest FC",
            "Bradford FC",
            "West Ham United FC",
            "Bournemouth FC",
            "Burnley FC",
            "Sheffield Wednesday FC",
            "Crystal Palace FC",
            "Southampton FC",
            "Everton FC",
            "Norwich City FC",
            "Aston Villa FC",
            "Wolves FC"
    };

    private List<String> ls = new ArrayList<>(Arrays.asList(ss));
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter(this, R.layout.items, R.id.tvItems, ls);
        listView.setAdapter(adapter);
    }

    //inflate menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miAscending:
                ls.sort(Comparator.naturalOrder());
                adapter.notifyDataSetChanged();
                break;
            case R.id.miDescending:
                ls.sort(Comparator.reverseOrder());
                adapter.notifyDataSetChanged();
                break;
        }
        return true;
    }
}
