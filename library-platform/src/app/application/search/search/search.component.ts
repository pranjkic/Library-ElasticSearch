import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {LibraryService} from '../../../services/library.service'
import {FormGroup, FormControl, Validators } from '@angular/forms';
import { SimpleQuery } from '../../../model/model';


@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchResult: Array<any>;
  allFields: Array<string>;

  querySearchForm = new FormGroup({
    query: new FormControl('love'),
  });

  termSearchForm = new FormGroup({
    field: new FormControl('title'),
    value: new FormControl(''),
  });

  constructor(private libraryService: LibraryService) {}

  ngOnInit(): void {
    this.loadFields();
  }

  onQuerySearchFormSubmit(){
    var simpleQuery = new SimpleQuery(null, this.querySearchForm.get('query').value);

    this.libraryService.querySearch(simpleQuery)
      .subscribe((data) => {        
        this.searchResult = data["body"];
        console.log(this.searchResult);
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

  onTermSearchFormSubmit(){
    var field = this.termSearchForm.get('field').value;
    var value = this.termSearchForm.get('value').value;
    var simpleQuery = new SimpleQuery(field, value);
    
    this.libraryService.termSearch(simpleQuery)
      .subscribe((data) => {        
        this.searchResult = data["body"];
        console.log(this.searchResult);
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }

  loadFields(){
    this.allFields = new Array<string>();
    this.allFields.push("title");
    this.allFields.push("author");
    this.allFields.push("content");
    this.allFields.push("genre");
  }





  
  // public getSomething(): void{
  //    this.libraryService.getSomething()
  //   .subscribe((response) => {
  //       this.something = response['response'];
  //     },
  //     (error: HttpErrorResponse) => {
  //       alert(error.message)
  //       //console.log(error.message)
  //     }
  //   );
  // }

}
