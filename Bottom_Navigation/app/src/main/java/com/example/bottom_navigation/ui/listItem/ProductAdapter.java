package com.example.bottom_navigation.ui.listItem;

/**
 * Created by karanjaswani on 1/12/18.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bottom_navigation.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Product> productList;

    private Boolean isProfile;

    //getting the context and product list with constructor
    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    public ProductAdapter(Context mCtx, List<Product> productList, Boolean isProfile) {
        this.mCtx = mCtx;
        this.productList = productList;
        this.isProfile = true;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_products, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Product product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewContactInfo.setText(product.getContactinfo());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }



    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewContactInfo;
        ImageView imageView;
        public ImageView mDeleteImage;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewContactInfo = itemView.findViewById(R.id.textViewContactInfo);
            imageView = itemView.findViewById(R.id.imageView);
            mDeleteImage = itemView.findViewById(R.id.deleteButton);
            if(!isProfile) {
                mDeleteImage.setVisibility(View.GONE);
            } else {
                mDeleteImage.setVisibility(View.VISIBLE);
            }

            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(mCtx);
                    alert.setTitle("Delete Listing");
                    alert.setMessage("Are you sure you want to delete this listing?");
                    alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            productList.remove(0);
                            notifyDataSetChanged();
                            Toast toast = Toast.makeText(mCtx, "Successfully deleted listing", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                        }
                    });
                    alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog dialog = alert.create();
                    dialog.show();
                }
            });
        }
    }
}