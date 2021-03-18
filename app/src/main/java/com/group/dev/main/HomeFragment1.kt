package com.group.dev.main

import android.content.Intent
import android.util.Log
import android.view.View
import com.group.common.adapter.ItemCell
import com.group.common.base.BaseSampleFragment
import com.group.common.core.ExtraConst
import com.group.common.ext.openActivity
import com.group.common.ext.toast
import com.group.common.util.SysUtil
import com.group.dev.ui.WebActivity
import com.group.dev.ui.clock.ClockActivity
import com.group.dev.ui.decoration_sticky.DecorationStickyActivity
import com.group.dev.ui.fish.FishActivity
import com.group.dev.ui.flextag.FlexActivity
import com.group.dev.ui.item_swipe.ItemSwipeActivity
import com.group.dev.ui.other.*
import com.group.dev.ui.qmhome.StickyTop2Activity
import com.group.dev.ui.sticky.StickyTop1Activity
import com.group.dev.ui.tantan.TanTanActivity

/**
 * 描述:
 *
 * author zys
 * create by 2021/2/14
 */
class HomeFragment1 : BaseSampleFragment() {


    override fun init(view: View) {
        setTitle("Home", false)
    }

    override fun initList(): List<ItemCell> {
        val list = mutableListOf<ItemCell>()

        list.add(MainCell("仿UC首页") {
            openActivity<UCHomeActivity>(it)
        })
        list.add(MainCell("图片裁剪") {
            openActivity<ClipImageActivity>(it)
        })
        list.add(MainCell("Ruler-View") {
            openActivity<RulerActivity>(it)
        })
        list.add(MainCell("炫彩时钟") {
            openActivity<ClockActivity>(it)
        })

        list.add(MainCell("悬浮置顶1") {
            openActivity<StickyTop1Activity>(it)
        })
        list.add(MainCell("悬浮置顶2") {
            openActivity<StickyTop2Activity>(it)
        })
        list.add(MainCell("测试") {
            openActivity<TestActivity>(it)
        })
        list.add(MainCell("IP") {
            Log.i("测试TAG", SysUtil.getLocalIpAddress())
            toast(SysUtil.getLocalIpAddress())
        })
        list.add(MainCell("Text测试") {
            openActivity<TextActivity>(it)
        })
        list.add(MainCell("流式布局") {
            openActivity<FlexActivity>(it)
        })
        list.add(MainCell("HookActivity") {
//            openActivity<HookActivity>(it)
        })
        list.add(MainCell("分组-悬浮") {
            openActivity<DecorationStickyActivity>(it)
        })
        list.add(MainCell("仿探探卡片") {
            openActivity<TanTanActivity>(it)
        })
        list.add(MainCell("灵动的锦鲤") {
            openActivity<FishActivity>(it)
        })
        list.add(MainCell("在线PDF") {
            val url = "http://zjj.sz.gov.cn/attachment/0/749/749839/8545777.pdf"
            val pdfUrl = PDF_PREFIX + url
            startActivity(
                Intent(requireContext(), WebActivity::class.java)
                    .putExtra(ExtraConst.WEB_URL, pdfUrl)
                    .putExtra(ExtraConst.ACTIVITY_TITLE, "在线PDF")
            )
        })
        list.add(MainCell("侧滑删除") {
            openActivity<ItemSwipeActivity>(it)
        })
        return list
    }

    companion object {

        const val PDF_PREFIX = "file:///android_asset/pdf/web/viewer.html?file="
    }

}