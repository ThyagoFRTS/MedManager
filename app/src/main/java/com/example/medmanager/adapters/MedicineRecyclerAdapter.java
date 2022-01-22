package com.example.medmanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medmanager.databinding.MedicineItemBinding;
import com.example.medmanager.db.DbRoomDatabase;
import com.example.medmanager.models.Medicine;
import com.example.medmanager.staticData.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;


public class MedicineRecyclerAdapter extends RecyclerView.Adapter<MedicineRecyclerAdapter.ViewHolder> implements Filterable {

    private List<Medicine> dataMedicineListFull;
    private List<Medicine> dataMedicineList;
    private Context context;

    public MedicineRecyclerAdapter(Context context) {
        this.context = context;
        //this.data = Data.getMedicines();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MedicineItemBinding itemBinding = MedicineItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medicine med = dataMedicineList.get(position);
        holder.bind(med);
    }

    @Override
    public int getItemCount() {
        if (dataMedicineList == null){
            return 0;
        } else {
            return dataMedicineList.size();
        }
    }
    /*
    public void refresh(List<Medicine> MedicineList) {
        notifyItemRangeRemoved(0, this.dataMedicineListFull.size());
        this.dataMedicineListFull.clear();
        this.dataMedicineListFull.addAll(MedicineList);
        notifyItemRangeInserted(0, this.dataMedicineListFull.size());
    }*/

    public void setMedicineList(List<Medicine> data) {
        this.dataMedicineList = data;
        this.dataMedicineListFull = new ArrayList<>(data);
        notifyDataSetChanged();
    }

    private Filter medicineFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Medicine> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(dataMedicineListFull);
            } else {
                String search = constraint.toString().toLowerCase().trim();
                for (Medicine med: dataMedicineListFull) {
                    if (med.getName().toLowerCase().contains(search)){
                        filteredList.add(med);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dataMedicineList.clear();
            dataMedicineList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    @Override
    public Filter getFilter() {
        return medicineFilter;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView price;
        private final TextView quantity;
        private final ImageButton edit;
        private final ImageButton delete;

        MedicineItemBinding binding;

        public ViewHolder(@NonNull MedicineItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            name = binding.txtNameMedicineItem;
            price = binding.txtUnityMedicineItem;
            quantity = binding.txtQuantityMedicineItem;
            edit = binding.btnEditMedicineItem;
            delete = binding.btnDeleteMedicineItem;

        }

        public void bind(Medicine medicine) {
            name.setText(medicine.getName());
            quantity.setText(String.format("Quantity: %d", medicine.getQuantity()));
            price.setText(String.format("Unity Price: %s", medicine.getUnityPrice()));
        }

    }
}
