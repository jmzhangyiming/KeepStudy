package com.wj.sampleproject.fragment

import android.os.Bundle
import cn.wj.android.base.adapter.FragVpAdapter
import cn.wj.android.base.adapter.creator
import com.wj.sampleproject.R
import com.wj.sampleproject.base.ui.BaseFragment
import com.wj.sampleproject.databinding.AppFragmentBjnewsBinding
import com.wj.sampleproject.viewmodel.BjnewsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * 公众号
 */
class BjnewsFragment
    : BaseFragment<BjnewsViewModel, AppFragmentBjnewsBinding>() {

    override val viewModel: BjnewsViewModel by viewModel()

    override val layoutResId: Int = R.layout.app_fragment_bjnews

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 获取公众号数据
        viewModel.getBjnewsList()
    }

    override fun initView() {
    }

    override fun initObserve() {
        // 公众号列表
        viewModel.bjnewsData.observe(this, {
            // 配置 ViewPager
            mBinding.vpBjnews.adapter = FragVpAdapter.newBuilder()
                    .manager(childFragmentManager)
                    .creator {
                        count(it.size)
                        createFragment { position ->
                            BjnewsArticlesFragment.actionCreate(it[position])
                        }
                    }
                    .pageTitle { _, i -> it[i].name.orEmpty() }
                    .build()
            mBinding.stlBjnews.setViewPager(mBinding.vpBjnews)
        })
    }

    companion object {

        /** 创建 [BjnewsFragment] 并返回 */
        fun actionCreate(): BjnewsFragment {
            return BjnewsFragment()
        }
    }
}