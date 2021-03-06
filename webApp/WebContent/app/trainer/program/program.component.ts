import { DataService } from '../../Services/data/data.service';
import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PROGRAM} from "../../Model/program.model";

@Component({
  selector: 'app-program',
  templateUrl: './program.component.html',
  styleUrls: ['./program.component.css']
})
export class ProgramComponent implements OnInit {
  showError: boolean;
  private program: PROGRAM;

  constructor(private dataService:DataService,
              private router: Router) {

  }
  ngOnInit() {
    this.getTrainerProgram()
  }

    private getTrainerProgram() {
    this.dataService.getProgramForUser()
      .subscribe((data)=> {
        if (data != null) {
          this.program = <PROGRAM> data;
        
          if(this.program.rmFilled === false){
            this.router.navigate(['rm']);
          } else {
            this.router.navigate(['current-program']);
          }
        } else {
          this.showError = true;
        }
      
      },(err)=>{
        this.showError = true;
      },()=>{
        console.log('done')
      })
  }

}
