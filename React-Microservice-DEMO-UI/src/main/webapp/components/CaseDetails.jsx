import React, { Component } from 'react'

class Table extends Component {
    constructor(props) {
        super(props)
        this.state = {
            casesData: [
                //Mapping to Dynamic data

            ]
        }
    }

    render() {
        return (
            <div>
                <h1>Month</h1>
                <h1>Cases</h1>
            </div>
        )
    }
}