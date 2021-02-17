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

  querySearchForm = new FormGroup({
    query: new FormControl('love'),
  });

  constructor(private libraryService: LibraryService) {}

  ngOnInit(): void {
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
