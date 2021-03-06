package nodomain.shvydkoy.chronicler.channelsScreen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nodomain.shvydkoy.chronicler.R;
import nodomain.shvydkoy.chronicler.api.subcribtions.SubsManager;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;



public final class ChannelListFragment extends Fragment
{
    private RecyclerView recyclerView;
    private ChannelRecyclerViewAdapter channelRecyclerViewAdapter;

    public ChannelListFragment() {}


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_channel_list, container, false);

        recyclerView = view.findViewById(R.id.channel_list);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Context context = view.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(channelRecyclerViewAdapter);


        DividerItemDecoration decoration = new DividerItemDecoration(context, VERTICAL);
        recyclerView.addItemDecoration(decoration);
    }



    public void setSubsManager(final SubsManager subsManager)
    {
        channelRecyclerViewAdapter = new ChannelRecyclerViewAdapter(subsManager);
        channelRecyclerViewAdapter.notifyDataSetChanged();
    }




}
