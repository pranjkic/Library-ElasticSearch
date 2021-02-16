import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainviewComponent } from './application/mainview/mainview/mainview.component';
import { SidebarComponent } from './application/sidebar/sidebar/sidebar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import { HomeComponent } from './application/home/home/home.component';
import { SearchComponent } from './application/search/search/search.component';
import { HttpClientModule } from '@angular/common/http';
import { IndexingComponent } from './application/indexing/indexing/indexing.component'
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    MainviewComponent,
    SidebarComponent,
    HomeComponent,
    SearchComponent,
    IndexingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatCardModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
