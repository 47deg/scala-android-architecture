package com.fortysevendeg.architecture.ui.main.transformations

import android.support.v7.widget.GridLayoutManager
import com.fortysevendeg.architecture.jobs.main.MainListUiActions
import com.fortysevendeg.architecture.services.api.Animal
import com.fortysevendeg.architecture.ui.main.adapters.AnimalsAdapter
import com.fortysevendeg.macroid.extras.ImageViewTweaks._
import com.fortysevendeg.macroid.extras.RecyclerViewTweaks._
import com.fortysevendeg.macroid.extras.ViewTweaks._
import com.fortysevendeg.scala.architecture.R
import macroid.FullDsl._
import macroid._

import scala.language.postfixOps

trait MainListUiActionsImpl
  extends MainListUiActions {

  self : MainBinding =>

  implicit val contextWrapper: ActivityContextWrapper

  def loadAnimals(data: Seq[Animal]): Ui[Any] =
    (recycler
      <~ rvAdapter(new AnimalsAdapter(data))
      <~ rvFixedSize
      <~ rvLayoutManager(new GridLayoutManager(contextWrapper.bestAvailable, 2))) ~
      (fabActionButton
        <~ ivSrc(R.drawable.ic_add)
        <~ On.click(content <~ vSnackbarLong(R.string.material_list_add_item)))

}

