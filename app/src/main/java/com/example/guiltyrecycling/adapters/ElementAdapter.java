package com.example.guiltyrecycling.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiltyrecycling.R;
import com.example.guiltyrecycling.models.Element;

import java.util.ArrayList;
import java.util.List;

public class ElementAdapter extends RecyclerView.Adapter<ElementAdapter.ElementViewHolder> {

    private ElementClickListener elementClickListener;
    private Context mContext;
    private List<Element> myElements;
    private List<Element> initialElements;

    // Adapter initialization
    public ElementAdapter(Context mContext, List<Element> myElements) {
        this.mContext = mContext;
        this.myElements = myElements;
        this.initialElements = myElements;
    }

    public List<Element> getMyElements() {
        return myElements;
    }

    public void setMyElements(List<Element> elements) {
        this.myElements = elements;
    }

    public Element getElement(int position){
        return myElements.get(position);
    }

    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_item, parent, false);
        return new ElementViewHolder(view);
    }


    // function that determines how to display each item in the list by their position
    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, @SuppressLint("RecyclerView") int position) {

        try{
            Element element = myElements.get(position);
            holder.tvElementTitle.setText(element.getTitle());

            // If element is recyclable, change the text color
            if(element.isRecyclable()){
                holder.tvElementTitle.setTextColor(mContext.getColor(android.R.color.holo_green_dark));
            }else{
                holder.tvElementTitle.setTextColor(mContext.getColor(android.R.color.holo_red_dark));
            }

            holder.tvElementTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(elementClickListener != null){
                        elementClickListener.onElementClick(position); // Send the click event to the activity
                    }
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return myElements.size();
    }

    // Class that initialize the view of each element in the list
    public class ElementViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tvElementTitle;

        public ElementViewHolder(@NonNull View itemView) {
            super(itemView);
            tvElementTitle = itemView.findViewById(R.id.tv_element_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    // Interface that allows you to redirect the click event from adapter to activity
    public interface ElementClickListener{
        void onElementClick(int position);
    }

    public ElementClickListener getElementClickListener() {
        return elementClickListener;
    }

    public void setElementClickListener(ElementClickListener elementClickListener) {
        this.elementClickListener = elementClickListener;
    }

    public void filter(String text){
        try{
            List<Element> filtered = new ArrayList<>();
            if(!TextUtils.isEmpty(text)){
                for (Element element : this.myElements) {


                    String[] searchWords = text.split(" "); //Split search into words array;
                    String[] elementNameWords = element.getTitle().split(" "); //Split element name into words array;

                    // Comparing words
                    for (String match1: searchWords) {
                        for(String match2 : elementNameWords){
                            if(match2.toLowerCase().contains(match1.toLowerCase())){
                                if(!filtered.contains(element)){
                                    filtered.add(element);
                                }
                            }
                        }
                    }

//                    if(text.toLowerCase().contains(element.getTitle().toLowerCase())){
//                        filtered.add(element);
//                    }
                }

                if(filtered.size() > 0){
                    setMyElements(filtered);
                    notifyDataSetChanged();
                }else{
                    setMyElements(initialElements);
                    notifyDataSetChanged();
                }
            }else{
                setMyElements(initialElements);
                notifyDataSetChanged();
            }
        }catch (Exception e){
            e.printStackTrace();
            setMyElements(initialElements);
            notifyDataSetChanged();
        }

    }





}
