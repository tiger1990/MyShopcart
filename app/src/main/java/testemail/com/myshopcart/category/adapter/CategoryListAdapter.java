package testemail.com.myshopcart.category.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import testemail.com.myshopcart.R;
import testemail.com.myshopcart.category.entitymodel.CategoryResponseVo;

/**
 * Created by rohit on 2/7/2016.
 */
public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>
{
    private ArrayList<CategoryResponseVo> _categoryListData;
    private WeakReference<ICategoryClickListener> _currentReference;

    public interface ICategoryClickListener
    {
        void onCategoryClick(CategoryResponseVo categoryResponseVo);
    }

    public CategoryListAdapter(ArrayList<CategoryResponseVo> categoryListData, ICategoryClickListener context)
    {
        _categoryListData = categoryListData;
        _currentReference = new WeakReference<ICategoryClickListener>(context);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount()
    {
        return _categoryListData.size();
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item_row, parent, false);
        CategoryViewHolder vh = new CategoryViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position)
    {
        CategoryResponseVo categoryResponseVo = _categoryListData.get(position);
        holder.categoryName.setText(categoryResponseVo.getCategoryName());
        holder.categoryDesc.setText(categoryResponseVo.getCategoryDesc());
        holder.conatinerLinearLayout.setTag(position);

    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public TextView categoryName;
        public TextView categoryDesc;
        LinearLayout conatinerLinearLayout;

        public CategoryViewHolder(View v)
        {
            super(v);
            categoryName = (TextView) v.findViewById(R.id.categoryName);
            categoryDesc = (TextView) v.findViewById(R.id.categoryDesc);
            conatinerLinearLayout = (LinearLayout) v.findViewById(R.id.conatinerLinearLayout);
            conatinerLinearLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.conatinerLinearLayout:
                    int position=(int)v.getTag();
                    _currentReference.get().onCategoryClick(_categoryListData.get(position));
                    break;
            }
        }
    }

}

