import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import {LibraryService} from '../../../services/library.service'

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  public something: string;

  constructor(private libraryService: LibraryService) {}

  ngOnInit(): void {
    this.getSomething();
  }
  
  public getSomething(): void{
     this.libraryService.getSomething()
    .subscribe((response) => {
        this.something = response['response'];
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
        //console.log(error.message)
      }
    );
  }

}
