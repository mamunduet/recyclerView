package com.alphaplus.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mamun on 3/10/2016.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private List<ContactInfo> contactList;

    public ContactAdapter(List<ContactInfo> contactList) {
        this.contactList = contactList;
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        ContactInfo ci = contactList.get(i);
        contactViewHolder.vName.setText(ci.name);
        contactViewHolder.vDes.setText(ci.des);
        contactViewHolder.vDis.setText(ci.dis);
        SpannableString content = new SpannableString(ci.date);
        content.setSpan(new UnderlineSpan(), 0, ci.date.length(), 0);
        contactViewHolder.vDate.setText(content);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_view, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vDes;
        protected TextView vDis;
        protected TextView vDate;

        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.txtName);
            vDes = (TextView)  v.findViewById(R.id.txtDes);
            vDis = (TextView)  v.findViewById(R.id.txtDis);
            vDate = (TextView) v.findViewById(R.id.txtDate);
        }
    }
}