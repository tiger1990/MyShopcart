package testemail.com.myshopcart.product.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import testemail.com.myshopcart.R;
import testemail.com.myshopcart.product.entitymodel.ProductResponseVo;


public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>
{
    private ArrayList<ProductResponseVo> _productList;

    public ProductListAdapter(ArrayList<ProductResponseVo> categoryListData)
    {
        _productList = categoryListData;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount()
    {
        return 8;//_productList.size();
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_grid_layout_row, parent, false);
        ProductViewHolder vh = new ProductViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position)
    {
//        ProductResponseVo categoryResponseVo = _productList.get(position);
//        holder.categoryName.setText(categoryResponseVo.getCategoryName());
//        holder.categoryDesc.setText(categoryResponseVo.getCategoryDesc());

    }

    public class ProductViewHolder extends RecyclerView.ViewHolder
    {

        public TextView categoryName;
        public TextView categoryDesc;

        public ProductViewHolder(View v)
        {
            super(v);
//            categoryName = (TextView) v.findViewById(R.id.categoryName);
//            categoryDesc = (TextView) v.findViewById(R.id.categoryDesc);
        }
    }

}

