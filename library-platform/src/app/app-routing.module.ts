import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { from } from 'rxjs';
import { MainviewComponent } from '../app/application/mainview/mainview/mainview.component'
import { HomeComponent } from '../app/application/home/home/home.component'
import { SearchComponent } from '../app/application/search/search/search.component'
import { IndexingComponent } from '../app/application/indexing/indexing/indexing.component'

const routes: Routes = [
  {path: "", component: MainviewComponent, children: [
    {path: "home", component: HomeComponent},
    {path: "search", component: SearchComponent},
    {path: "index", component: IndexingComponent},
  ]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
