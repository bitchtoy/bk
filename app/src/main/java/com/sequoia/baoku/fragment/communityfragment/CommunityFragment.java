package com.sequoia.baoku.fragment.communityfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sequoia.baoku.R;
import com.sequoia.baoku.base.BaseFragment;
import com.sequoia.baoku.fragment.communityfragment.childfrg.DynamicFrg;
import com.sequoia.baoku.fragment.communityfragment.childfrg.RecommendFrg;
import com.sequoia.baoku.fragment.communityfragment.communityadapter.RecmPageAdapter;
import com.sequoia.baoku.fragment.communityfragment.communityadapter.RecommendAdapter;
import com.sequoia.baoku.fragment.communityfragment.communitybean.RecommendBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * @author Administrator.
 * @date 2018/4/26.
 * @funtion
 */

public class CommunityFragment extends BaseFragment {

    @BindView(R.id.tool_bar_title)
    TextView mToolBarTitle;
    @BindView(R.id.tool_bar_img_one)
    ImageButton mToolBarImgOne;
    @BindView(R.id.tool_bar_img_two)
    ImageButton mToolBarImgTwo;
    Unbinder unbinder;
    @BindView(R.id.community_frg_card_img)
    LinearLayout mCommunityFrgCardImg;
    @BindView(R.id.community_frg_tj)
    RecyclerView mCommunityFrgTj;
    @BindView(R.id.community_tab)
    TabLayout mCommunityTab;
    @BindView(R.id.community_frg_vp)
    ViewPager mCommunityFrgVp;
    @BindView(R.id.flost_ask)
    FloatingActionButton flost_ask;

    private LinearLayoutManager mManager = null;
    private RecommendAdapter mAdapter = null;

    public static CommunityFragment getInstanceCommunityFragment() {
        return new CommunityFragment();
    }

    @Override
    protected int setView() {
        return R.layout.fragment_community_layout;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        initLayout();
    }

    //初始化toolbar
    private void initLayout() {
        mToolBarTitle.setText(R.string.index_bottom_community_tab);
        mToolBarImgTwo.setImageResource(R.drawable.search);
        mToolBarImgOne.setImageResource(R.drawable.msg);
        //card view
        for (int i = 0; i < DeathLayoutData.cardImg.length; i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.frg_community_t_card_view_item, null, false);
            ImageView cardImg = view.findViewById(R.id.community_frg_card_img);
            cardImg.setImageResource(DeathLayoutData.cardImg[i]);
            view.setId(i);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int horizontalScrollViewId = v.getId();
                    switch (horizontalScrollViewId) {
                        case DeathLayoutData.HSV_ID_ONE:

                            break;
                        case DeathLayoutData.HSV_ID_TWO:

                            break;
                        case DeathLayoutData.HSV_ID_THREE:

                            break;
                        case DeathLayoutData.HSV_ID_FOUR:

                            break;
                        case DeathLayoutData.HSV_ID_FIVE:

                            break;
                        default:
                            break;

                    }
                }
            });
            mCommunityFrgCardImg.addView(view);
        }
        //da niu  tui jian
        List<RecommendBean> list = new ArrayList<>();
        for (int y = 0; y < DeathLayoutData.decride.length; y++) {
            RecommendBean bean = new RecommendBean();
            bean.img = DeathLayoutData.Img[y];
            bean.user = DeathLayoutData.user[y];
            bean.describe = DeathLayoutData.decride[y];
            list.add(bean);
        }
        mManager = new LinearLayoutManager(getContext());
        mManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mCommunityFrgTj.setLayoutManager(mManager);
        mAdapter = new RecommendAdapter(mCommunityFrgTj);
        mCommunityFrgTj.setAdapter(mAdapter);
        mAdapter.setData(list);
        //tab layout view page
        mCommunityTab.addTab(mCommunityTab.newTab());
        mCommunityTab.addTab(mCommunityTab.newTab());
        initVP();
        mCommunityTab.setupWithViewPager(mCommunityFrgVp);
        mCommunityTab.getTabAt(0).setCustomView(customTabView(R.string.tab_one, R.drawable.tab_fire));
        mCommunityTab.getTabAt(1).setCustomView(customTabView(R.string.tab_two, R.drawable.tab_user));
    }

    private void initVP() {
        List<Fragment> frgs = new ArrayList<>();
        frgs.add(RecommendFrg.getInstance());
        frgs.add(DynamicFrg.getInstance());
        RecmPageAdapter vp = new RecmPageAdapter(mActivity.getSupportFragmentManager(), frgs);
        mCommunityFrgVp.setAdapter(vp);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //HSV VIEW ITEM ID LISTENNER


    //自定义tab layout 布局分布
    private View customTabView(int content, int imgId) {
        View tabView = LayoutInflater.from(getContext()).inflate(R.layout.community_coustom_tab_view, null, false);
        ImageView tabImg = tabView.findViewById(R.id.custom_tab_img);
        TextView tabTxt = tabView.findViewById(R.id.custom_tab_content);
        tabImg.setImageResource(imgId);
        tabTxt.setText(content);
        return tabView;
    }


    @OnClick(R.id.flost_ask)
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.flost_ask:
                Intent ask = new Intent(getContext(), AskActivity.class);
                startActivity(ask);
                break;
             default:
                 break;

        }
    }
}
