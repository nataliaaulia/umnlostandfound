package com.example.bottom_navigation.ui.information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import android.widget.ExpandableListView;
import android.widget.TextView;


import android.widget.BaseExpandableListAdapter;


import com.example.bottom_navigation.R;

public class InformationFragment extends Fragment {

    View rootView;
    ExpandableListView lv;
    private String[] steps;
    private String[][] children;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        steps = new String[] { "Retracing Your Steps", "Getting Help Looking for the Item", "Keeping Yourself from Losing Things in the Future" };

        children = new String [][] {
                { "Determine the last time you saw the item. It’s probably obvious, but the first step in tracking down the thing you’ve lost is picturing where you last had it. Go back to the place where you last saw the item and see if it's there. Another thing that might help is to walk through all of the locations you’ve been since you lost the item. When you remember the last time you saw your missing item, you’ll want to go back to all of the spots you’ve been since you last had it." },
                { "Ask friends, coworkers, and/or family members. Sometimes, you may think you’ve lost something when someone else just borrowed or moved it. Ask anyone who’s been around the item if they’ve seen it or know where it is. Please also try to visit the nearest lost and found office and check if they keep your lost item for you. If your item isn’t in the lost-and-found yet, leave your contact info. That way, they can get in touch with you if it does show up."},
                { "Be consciously aware as you go through your daily routine. In addition to that, keep your home and work areas uncluttered and have specific spots to store items. The easiest way to keep from losing stuff is having certain spots where you put your items at the end of the day. " },
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_information, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lv = (ExpandableListView) view.findViewById(R.id.expandableListView);
        lv.setAdapter(new ExpandableListAdapter(steps, children));
        lv.setGroupIndicator(null);

    }

    public class ExpandableListAdapter extends BaseExpandableListAdapter {

        private final LayoutInflater inf;
        private String[] groups;
        private String[][] children;

        public ExpandableListAdapter(String[] groups, String[][] children) {
            this.groups = groups;
            this.children = children;
            inf = LayoutInflater.from(getActivity());
        }

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_item, parent, false);
                holder = new ViewHolder();

                holder.text = (TextView) convertView.findViewById(R.id.expandedListItem);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getChild(groupPosition, childPosition).toString());

            return convertView;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = inf.inflate(R.layout.list_group, parent, false);

                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.listTitle);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text.setText(getGroup(groupPosition).toString());

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        private class ViewHolder {
            TextView text;
        }
    }
}