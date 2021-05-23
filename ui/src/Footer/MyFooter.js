import React, { Component } from 'react'
import './MyFooter.css'

export default class MyFooter extends Component {
  render() {
    return (
      <div id="cts-footer">
        <div id="footer-navigation" role="navigation">
          <span className="copyright">
            Copyright @ 2021. All rights reserved.
          </span>
        </div>
      </div>
    )
  }
}
