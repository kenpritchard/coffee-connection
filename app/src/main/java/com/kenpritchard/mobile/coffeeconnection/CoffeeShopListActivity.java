package com.kenpritchard.mobile.coffeeconnection;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;


/**
 * An activity representing a list of CoffeeShops. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CoffeeShopDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link CoffeeShopListFragment} and the item details
 * (if present) is a {@link CoffeeShopDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link CoffeeShopListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class CoffeeShopListActivity extends Activity
        implements CoffeeShopListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffeeshop_list);
        if(savedInstanceState != null) {
            return;
        }

        if (findViewById(R.id.coffeeshop_detail_fragment) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
//            ((CoffeeShopListFragment) getFragmentManager()
//                    .findFragmentById(R.id.coffeeshop_list))
//                    .setActivateOnItemClick(true);
        } else {
            CoffeeShopListFragment listFragment = new CoffeeShopListFragment();
            listFragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(R.id.fragment_container, listFragment).commit();
        }
    }

    /**
     * Callback method from {@link CoffeeShopListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        Bundle arguments = new Bundle();
        arguments.putString(CoffeeShopDetailFragment.ARG_ITEM_ID, id);
        CoffeeShopDetailFragment fragment = new CoffeeShopDetailFragment();
        fragment.setArguments(arguments);
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            getFragmentManager().beginTransaction().replace(R.id.coffeeshop_detail_fragment, fragment).commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
//            Intent detailIntent = new Intent(this, CoffeeShopDetailActivity.class);
//            detailIntent.putExtra(CoffeeShopDetailFragment.ARG_ITEM_ID, id);
//            startActivity(detailIntent);
        }
    }
}
