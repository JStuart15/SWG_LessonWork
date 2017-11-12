import React from 'react';
import ReactDOM from 'react-dom';


class Form extends React.Component {
  constructor(){
    super();
    this.state = {
      companies: [],
    };
  }
componentWillMount(){
  fetch('http://localhost:8080/companies').then(results => {
    return results.json();
  }).then(data => {
    let companies = data.results.map((company) => {
      return(
        <div key={company.name}>
          <input type="text" value={company.name}/>
        </div>
      )
    })
    this.setState({companies: companies});
    console.log("state", this.state.companies);
  })
}

  render() {
    return (
      <form>
      {this.state.companies}

        <button type="submit" class="btn btn-primary">Submit</button>
      </form>

    );
  }
}

// ========================================

ReactDOM.render(
  <Form />,
  document.getElementById('root')
);
