package saurabh.digipodium.recyclerview_ex_1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    List<String> countries = new ArrayList<String>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        countries.add("Pigeon");
        countries.add("Owl");
        countries.add("Cock");
        countries.add("Swan");
        countries.add("Swan");
        countries.add("Cuckoo");
        countries.add("Nightingale");
        countries.add("parrot");
        countries.add("peacock");
        countries.add("Duck");
        countries.add("Hen");
        countries.add("Hawk");
        countries.add("Sparrow");
        countries.add("Vulture");
        countries.add("Woodpecker");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Integration of content with recycler view
        RecyclerView countryRv = view.findViewById(R.id.countryRv);
        countryRv.setLayoutManager((new LinearLayoutManager(getActivity())));
        CountryAdapter adapter= new CountryAdapter(getActivity(),R.layout.row_country,countries);
        countryRv.setAdapter(adapter);

    }

    class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.Holder>{
        private final Context context;
        private final int layout;
        private final List<String> countries;
        private final LayoutInflater inflator;

        //constructor; follow this order of constructor always

        public CountryAdapter(Context context, int layout, List<String> countries) {
            this.context=context;
            this.layout =layout;
            this.countries= countries;
            inflator = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflator.inflate(layout, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            String countryName= countries.get(position);
            holder.textCountry.setText(countryName);
        }

        @Override
        public int getItemCount() {
            return countries.size();
        }

        class Holder extends RecyclerView.ViewHolder{

            TextView textCountry;

            public Holder(@NonNull View itemView) {
                super(itemView);
                textCountry= itemView.findViewById(R.id.textCountry);
            }
        }
    }

}