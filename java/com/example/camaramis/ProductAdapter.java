package com.example.camaramis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends  RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

private Context mCtx;

private List<Product> productList;

public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(mCtx);
                View view = inflater.inflate(R.layout.list_layout,null);
                ProductViewHolder holder = new ProductViewHolder(view);
                return  holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
                Product product = productList.get(position);
                holder.textViewNumber.setText(product.getAfri_Number());
                holder.textViewShortDes.setText(product.getShort_Des());
                holder.textViewBrand.setText(String.valueOf(product.getBrand()));
                holder.textViewDate.setText(String.valueOf(product.getPro_Date()));
                holder.textViewStatus.setText(String.valueOf(product.getStatus()));


                //  Glide.with(mCtx)
                //   .load(product.getImage())
                //  .into(holder.imageView);


        }

        @Override
        public int getItemCount() {
                return productList.size();
        }

        class ProductViewHolder extends RecyclerView.ViewHolder{

                TextView textViewNumber, textViewShortDes, textViewBrand, textViewDate, textViewStatus;
                // ImageView imageView;
                public ProductViewHolder(@NonNull View itemView) {
                        super(itemView);
                        textViewNumber = itemView.findViewById(R.id.textViewNumber);
                        textViewShortDes = itemView.findViewById(R.id.textViewShortDes);
                        textViewDate = itemView.findViewById(R.id.textViewDate);
                        textViewBrand = itemView.findViewById(R.id.textViewBrand);
                        textViewStatus = itemView.findViewById(R.id.textViewStatus);
                        // imageView = itemView.findViewById(R.id.imageView);

                }
        }
}
